package com.sumup.purecode.users

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getById(id: Long): UserDto? {
        return userRepository.findByIdOrNull(id)
            ?.let(UserDto::fromEntity)
    }
}
