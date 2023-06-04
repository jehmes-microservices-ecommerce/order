package com.ecommerce.order.dtos;

import com.ecommerce.order.enums.ActionType;
import com.ecommerce.order.models.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.UUID;


@Data
public class UserEventDto {

    private UUID userId;
    private String username;
    private String email;
    private String cpf;
    private ActionType actionType;

    public User convertToUser() {
        var user = new User();
        BeanUtils.copyProperties(this, user);
        user.setUserId(this.userId.toString());
        return user;
    }
}
