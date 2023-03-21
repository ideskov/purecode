package com.sumup.purecode.users

data class UserDto(val id: Long, val firstName: String, val lastName: String, val email: String) {

    companion object {
        fun fromEntity(userEntity: UserEntity): UserDto = with(userEntity) {
            UserDto(id!!, firstName!!, lastName!!, email!!)
        }
    }
}
