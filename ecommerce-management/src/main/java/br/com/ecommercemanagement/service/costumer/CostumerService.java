package br.com.ecommercemanagement.service.costumer;

import br.com.ecommercemanagement.controller.costumer.CostumerDTO;
import br.com.ecommercemanagement.exception.BusinessException;
import br.com.ecommercemanagement.infrastructure.CostumerRepository;
import br.com.ecommercemanagement.model.CostumersEntity;
import br.com.ecommercemanagement.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CostumerService {

    public static final String COSTUMER_NOT_FOUND_TO_CODE = "Costumer not found to code";
    private final CostumerRepository costumerRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;

    public CostumerDTO createNewCostumer(CostumerDTO costumerDTO) {

        var entity = CostumersEntity
                .builder()
                .email(costumerDTO.getEmail())
                .pass(passwordEncoder.encode(costumerDTO.getPass()))
                .phone(costumerDTO.getPhone())
                .name(costumerDTO.getName())
                .build();

        return costumerRepository.save(entity).toDTO();
    }


    public CostumerDTO updateCostumer(CostumerDTO costumerDTO, Long id) {

        var costumer = costumerRepository.findById(id)
                .orElseThrow(() -> new BusinessException(COSTUMER_NOT_FOUND_TO_CODE, HttpStatus.NOT_FOUND));

        costumer.setName(costumerDTO.getName());
        costumer.setPhone(costumerDTO.getPhone());

        return costumerRepository.save(costumer).toDTO();
    }

    public void deleteCostumer(Long id) {
        costumerRepository.findById(id)
                .ifPresent(costumerRepository::delete);
    }


    public CostumerDTO loginUser(String email, String rawPassword) {

        var user = costumerRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("User not found", HttpStatus.BAD_REQUEST));

        if (passwordEncoder.matches(rawPassword, user.getPass())) {

            var jwt = "Bearer " + jwtUtil.generateToken(email);
            var userDto = user.toDTO();

            userDto.setAccessToken(jwt);

            return userDto;
        }
        throw new BusinessException("validate your data", HttpStatus.UNAUTHORIZED);

    }

    public void forgotPassword(String email) {

        var costumer = costumerRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Email not found", HttpStatus.BAD_REQUEST));

        String newPassword = UUID.randomUUID().toString().substring(0, 8);

        String encodedPassword = passwordEncoder.encode(newPassword);

        costumer.setPass(encodedPassword);

        costumerRepository.save(costumer);

        emailService.sendPasswordRecoveryEmail(email, newPassword);
    }

    public CostumerDTO findById(Long id) {
        return costumerRepository.findById(id).map(CostumersEntity::toDTO).orElseThrow();}
}
