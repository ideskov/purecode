package com.sumup.purecode.users;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<UserEntity, Long> {
}
