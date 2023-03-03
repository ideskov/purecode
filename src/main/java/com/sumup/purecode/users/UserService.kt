package com.sumup.purecode.users

import arrow.core.Either
import arrow.core.continuations.either
import arrow.core.continuations.ensureNotNull
import com.sumup.purecode.users.UserService.UserServiceError.NotFound
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    sealed interface UserServiceError {
        object NotFound : UserServiceError
    }

    fun getById(id: Long): Either<UserServiceError, UserDto> = either.eager {
        val userEntity = userRepository.findByIdOrNull(id)
        ensureNotNull(userEntity) { NotFound }
        UserDto(
            userEntity.id!!,
            userEntity.firstName!!,
            userEntity.lastName!!,
            userEntity.email!!
        )
    }
}
