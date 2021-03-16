package com.songbook.cognizantcodingchallenge.util

class Constant {
    companion object {
        const val EMAIL_REGEX = "[^@]+@[^.]+\\..+"
        const val PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"
    }

}