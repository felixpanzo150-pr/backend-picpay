package tech.felicxpanzo.picpay.service;

import org.springframework.stereotype.Service;
import tech.felicxpanzo.picpay.controller.dto.CreateWalletDto;
import tech.felicxpanzo.picpay.entity.Wallet;
import tech.felicxpanzo.picpay.exception.WalletDataAlreadyExistExcheption;
import tech.felicxpanzo.picpay.repository.WalletRepository;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()){
            throw new WalletDataAlreadyExistExcheption("cpfCnpj or Email already exists");
        }

       return walletRepository.save(dto.toWallet());
    }
}
