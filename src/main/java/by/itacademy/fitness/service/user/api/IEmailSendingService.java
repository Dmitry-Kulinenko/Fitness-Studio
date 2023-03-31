package by.itacademy.fitness.service.user.api;

public interface IEmailSendingService {
    void send(String email, String verificationLink);
}
