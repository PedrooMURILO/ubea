package com.abp.ubea.config;

import com.abp.ubea.entities.AdoptionRequestEntity;
import com.abp.ubea.entities.CatEntity;
import com.abp.ubea.entities.PartnerEntity;
import com.abp.ubea.entities.UserEntity;
import com.abp.ubea.entities.enums.InterestStatus;
import com.abp.ubea.entities.enums.UserRole;
import com.abp.ubea.repositories.AdoptionRequestRepository;
import com.abp.ubea.repositories.CatRepository;
import com.abp.ubea.repositories.PartnerRepository;
import com.abp.ubea.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DatabaseSeeding implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private AdoptionRequestRepository adoptionRequestRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity user1 = new UserEntity(null, "Pedro Murilo", "pedro@gmail.com", "12345678", UserRole.ADOPTER, true, "1799999999");
        UserEntity user2 = new UserEntity(null, "Alice", "alice@gmail.com", "12342378", UserRole.ADOPTER, false, "1792399999");
        UserEntity user3 = new UserEntity(null, "Bianca", "bianca@gmail.com", "2345678", UserRole.ADMIN, true, "179995799");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        partnerRepository.saveAll(Arrays.asList(
                new PartnerEntity(
                        null,
                        "Pet Shop Bichanos",
                        "Pet shop parceiro que doa ração e brinquedos para os gatos resgatados.",
                        "Rua das Flores, 123 - Centro, São José do Rio Preto - SP",
                        "(17) 3210-4567"
                ),
                new PartnerEntity(
                        null,
                        "Clínica Veterinária Amor Animal",
                        "Clínica parceira responsável pelos cuidados veterinários dos gatos.",
                        "Avenida Saúde Animal, 456 - Jardim Felino, São José do Rio Preto - SP",
                        "(17) 99876-1234"
                ),
                new PartnerEntity(
                        null,
                        "Casa do Gato",
                        "Loja especializada em produtos felinos, que oferece descontos para adotantes.",
                        "Rua dos Gatos, 789 - Vila Meow, São José do Rio Preto - SP",
                        "(17) 3344-7788"
                ),
                new PartnerEntity(
                        null,
                        "ONG Patas Felizes",
                        "Organização não governamental que colabora com resgates e eventos de adoção.",
                        "Rua Solidária, 55 - Bairro Esperança, São José do Rio Preto - SP",
                        "(17) 4002-8922"
                ),
                new PartnerEntity(
                        null,
                        "Fatec Vet",
                        "Curso de veterinária da Fatec que realiza castrações e exames básicos gratuitos.",
                        "Rua Acadêmica, 1010 - Campus Universitário, São José do Rio Preto - SP",
                        "(17) 3010-2020")
        ));

        catRepository.saveAll(Arrays.asList(
                new CatEntity(null, "Mingau", 'M', (byte) 2, "Gato branco, muito dócil e brincalhão.", false),
                new CatEntity(null, "Luna", 'F', (byte) 1, "Gatinha preta, muito curiosa e sociável.", false),
                new CatEntity(null, "Thor", 'M', (byte) 3, "Gato tigrado forte e calmo, adora ficar no colo.", true),
                new CatEntity(null, "Nina", 'F', (byte) 4, "Gata cinza, independente e esperta.", false),
                new CatEntity(null, "Zico", 'M', (byte) 5, "Gato preto e branco, muito carinhoso, já foi adotado.", true)
        ));

        adoptionRequestRepository.saveAll(Arrays.asList(
                new AdoptionRequestEntity(null, LocalDateTime.now(), InterestStatus.PENDING, null),
                new AdoptionRequestEntity(null, LocalDateTime.now().minusDays(5), InterestStatus.APPROVED, LocalDateTime.now().minusDays(2)),
                new AdoptionRequestEntity(null, LocalDateTime.now().minusDays(10), InterestStatus.REJECTED, LocalDateTime.now().minusDays(8)),
                new AdoptionRequestEntity(null, LocalDateTime.now().minusDays(3), InterestStatus.CANCELED, null),
                new AdoptionRequestEntity(null, LocalDateTime.now().minusDays(1), InterestStatus.PENDING, null)
        ));
    }
}
