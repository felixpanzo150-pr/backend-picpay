package tech.felicxpanzo.picpay.service;

import org.springframework.stereotype.Service;
import tech.felicxpanzo.picpay.client.AuthorizationClient;
import tech.felicxpanzo.picpay.entity.Transfer;
import tech.felicxpanzo.picpay.exception.PicPayException;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient, AuthorizationClient authorizationClient1) {

        this.authorizationClient = authorizationClient1;
    }

    public boolean isAuthorized(Transfer transfer){
        var resp = authorizationClient.isAuthorized();
        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
