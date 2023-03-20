package com.sumup.purecode.users;

public record UserDto(Long id, String firstName, String lastName, String email) {
    static UserDto fromEntity(UserEntity entity) {
        return new UserDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }
}
