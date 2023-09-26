import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

fun main() {
    val botOptions = DefaultBotOptions()
    val myBot = MyBot(botOptions)

    // Запускаем бота
    val botSession = DefaultBotSession()
    botSession.setToken(myBot.botToken)
    botSession.setOptions(botOptions)
    botSession.setCallback(myBot)
    botSession.start()

}