package tech.felicxpanzo.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.felicxpanzo.picpay.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
