package jellyinghead.board.common.model;

public record Result<T>(T data) {

    public static <T> Result<T> create(T data) {
        return new Result<>(data);
    }
}
