package com.klejar.backend.pokedexbackend.utils

import com.klejar.backend.pokedexbackend.entity.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class MyUserPrincipal( val user: UserEntity) : UserDetails {
    override fun isEnabled(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUsername(): String {
      return user.username
    }

    override fun isCredentialsNonExpired(): Boolean {
        return false;
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val auths = ArrayList<GrantedAuthority>()
        user.roles?.forEach { auths.add(SimpleGrantedAuthority(it)) }
        return auths
    }

}
