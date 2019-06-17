package com.d360.authorizationserver.entities

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table( name = "users")
data class User(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = null,

        @Column(name = "user_name")
        val userName: String = "",

        @Column(name = "password")
        val password: String = "",

        @Column(name = "version")
        val version: Int = 0,

        @Column(name = "enabled")
        val enabled: Boolean = false,

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_authorities", joinColumns
        = [JoinColumn(name = "authority_id", referencedColumnName = "id")],
                inverseJoinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")])
        val authorities: Collection<Authority> = mutableListOf()
)


@Entity
@Table( name = "authority")
data class Authority(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String? = null,

        @Column(name = "authority")
        val authority: String? = null
)