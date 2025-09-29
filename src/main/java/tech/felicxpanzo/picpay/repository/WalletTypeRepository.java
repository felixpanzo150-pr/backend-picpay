package tech.felicxpanzo.picpay.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.felicxpanzo.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
