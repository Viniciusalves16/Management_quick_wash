package com.example.management.controller;

import com.example.management.enumeration.RoleEnum;

import javax.management.relation.Role;

public record RegisterLoginDto(String login, String password, RoleEnum role) {


}
