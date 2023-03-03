package com.sumup.purecode.users

import com.sumup.purecode.exceptions.ErrorDto
import com.sumup.purecode.users.UserService.UserServiceError.NotFound
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        return userService.getById(id)
            .fold({ error ->
                when (error) {
                    is NotFound -> ResponseEntity.status(404).body(ErrorDto("User $id not found"))
                }
            }, { ResponseEntity.ok(it) })
    }
}
