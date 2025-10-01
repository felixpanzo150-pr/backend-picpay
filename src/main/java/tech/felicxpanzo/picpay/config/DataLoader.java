package tech.felicxpanzo.picpay.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import tech.felicxpanzo.picpay.entity.WalletType;
import tech.felicxpanzo.picpay.repository.WalletTypeRepository;

import java.util.Arrays;

import static org.apache.commons.lang3.BooleanUtils.forEach;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Arrays.stream(WalletType.Enum.values())
                .forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
