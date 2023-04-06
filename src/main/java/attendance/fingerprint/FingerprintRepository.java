package attendance.fingerprint;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FingerprintRepository extends JpaRepository<Fingerprint, Integer> {
    Optional<Fingerprint> findFingerprintByFingerHex(String fingerHex);
}
