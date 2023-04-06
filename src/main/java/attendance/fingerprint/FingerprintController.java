package attendance.fingerprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/attendance/fingerprint")
public class FingerprintController {
    private final FingerprintService fingerprintService;

    @Autowired
    public FingerprintController(FingerprintService fingerprintService) {
        this.fingerprintService = fingerprintService;
    }

    @GetMapping
    public List<Fingerprint> getFingerprints() {
        return fingerprintService.getFingerprints();
    }

    @PostMapping(value = "validate")
    public ResponseEntity<FingerprintResponse> validateFingerprint(@RequestBody Fingerprint fingerprint) {
        return fingerprintService.validateFingerprint(fingerprint);
    }

    @PostMapping(value = "enroll")
    public ResponseEntity<FingerprintResponse> enrollFingerprint(@RequestBody Fingerprint fingerprint) {
        return fingerprintService.enrollFingerprint(fingerprint);
    }
}
