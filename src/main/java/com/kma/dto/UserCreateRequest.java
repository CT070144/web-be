package com.kma.dto;

import com.kma.enums.UserType;
import com.kma.repository.entities.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Collection;

@Data
@Builder

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    String userName;
    String password;

}
