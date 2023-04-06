package attendance.fingerprint;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fingerprint")
public class Fingerprint {
    @Id
    @Column(name = "finger_hex")
    public String fingerHex;

    public String getFingerHex() {
        return fingerHex;
    }

    public void setFingerHex(String fingerHex) {
        this.fingerHex = fingerHex;
    }
}
