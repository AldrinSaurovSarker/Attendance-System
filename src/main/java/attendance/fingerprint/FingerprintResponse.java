package attendance.fingerprint;

public class FingerprintResponse {
    private boolean success;
    private String message;

    public FingerprintResponse() {
    }

    public FingerprintResponse(boolean success) {
        this.success = success;
    }

    public FingerprintResponse(String message) {
        this.message = message;
    }

    public FingerprintResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
