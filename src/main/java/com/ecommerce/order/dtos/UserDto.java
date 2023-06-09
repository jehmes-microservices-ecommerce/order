package com.ecommerce.order.dtos;

import com.ecommerce.order.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.UUID;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    public interface UserView {
        static interface Order{}
        static interface UserEvent{}
    }

    private UUID userId;
    @NotBlank(groups = {UserView.UserEvent.class,UserView.Order.class})
    @JsonView({UserView.UserEvent.class,UserView.Order.class})
    private String username;
    @NotBlank(groups = {UserView.UserEvent.class,UserView.Order.class})
    @JsonView({UserView.UserEvent.class,UserView.Order.class})
    private String email;
    @NotBlank(groups = {UserView.UserEvent.class,UserView.Order.class})
    @JsonView({UserView.UserEvent.class,UserView.Order.class})
    private String cpf;
    @JsonView({UserView.UserEvent.class})
    private String actionType;
    @JsonView({UserView.UserEvent.class})
    private String userType;

    public User convertToUser() {
        var user = new User();
        BeanUtils.copyProperties(this, user);
        user.setUserId(this.userId.toString());
        return user;
    }
}
