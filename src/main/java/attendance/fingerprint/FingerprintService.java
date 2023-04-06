package attendance.fingerprint;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FingerprintService {

    private final FingerprintRepository fingerprintRepository;

    public FingerprintService(FingerprintRepository fingerprintRepository) {
        this.fingerprintRepository = fingerprintRepository;
    }

    public List<Fingerprint> getFingerprints() {
        return fingerprintRepository.findAll();
    }

    public ResponseEntity<FingerprintResponse> validateFingerprint(Fingerprint fingerprint) {
        Optional<Fingerprint> fingerprintOptional = fingerprintRepository.findFingerprintByFingerHex(fingerprint.getFingerHex());

        if (fingerprintOptional.isPresent()) {
            return ResponseEntity.ok(new FingerprintResponse(true, "Fingerprint has been verified."));
        } else {
            return ResponseEntity.ok(new FingerprintResponse(false, "No valid fingerprint entry found."));
        }
    }

    public ResponseEntity<FingerprintResponse> enrollFingerprint(Fingerprint fingerprint) {
        Optional<Fingerprint> fingerprintOptional = fingerprintRepository.findFingerprintByFingerHex(fingerprint.getFingerHex());

        if (fingerprintOptional.isPresent()) {
            return ResponseEntity.ok(new FingerprintResponse(false, "The fingerprint is already present in the database."));
        } else {
            fingerprintRepository.save(fingerprint);
            return ResponseEntity.ok(new FingerprintResponse(true, "Fingerprint stored in the database"));
        }
    }
}
