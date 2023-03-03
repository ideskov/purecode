package com.sumup.purecode.users

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "users")
class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "first_name")
    var firstName: String? = null

    @Column(name = "last_name")
    var lastName: String? = null

    @Column(name = "email")
    var email: String? = null
}