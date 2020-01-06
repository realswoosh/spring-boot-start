package com.example.realdm99.chapter4.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.chapter4.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
