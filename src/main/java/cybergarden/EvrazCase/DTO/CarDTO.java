package cybergarden.EvrazCase.DTO;

public record CarDTO(
        Long destId,
        Long companyId,
        Long headId,
        Long trackId,
        Long wagonid
) {
    @Override
    public Long destId() {
        return destId;
    }

    @Override
    public Long companyId() {
        return companyId;
    }

    @Override
    public Long headId() {
        return headId;
    }

    @Override
    public Long trackId() {
        return trackId;
    }

    @Override
    public Long wagonid() {
        return wagonid;
    }
}
