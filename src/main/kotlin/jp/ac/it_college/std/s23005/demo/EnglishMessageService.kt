package jp.ac.it_college.std.s23005.demo

import org.springframework.stereotype.Component

@Component("EnglishMessageService")
class EnglishMessageService : MessageService {
    override fun welcom() = "Welcom"
}