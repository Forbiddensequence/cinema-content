package ru.sequence.forbidden.cinemacontent

import org.springframework.boot.fromApplication
import org.springframework.boot.with
fun main(args: Array<String>) {
    fromApplication<CinemaContentApplication>().with(TestcontainersConfiguration::class).run(*args)
}
