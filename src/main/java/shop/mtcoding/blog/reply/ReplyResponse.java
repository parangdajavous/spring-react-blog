package shop.mtcoding.blog.reply;


import lombok.Data;

public class ReplyResponse {

    @Data
    public static class DTO {
        private Integer replyId;
        private Integer boardId;
        private Integer userId;
        private String comment;


        public DTO(Reply reply) {
            this.replyId = reply.getId();
            this.boardId = reply.getBoard().getId();
            this.userId = reply.getUser().getId();
            this.comment = reply.getComment();
        }
    }

    @Data
    public static class DetailDTO {
        private Integer id;
        private String comment;
        private Integer userId;
        private String username;
        private Boolean owner;

        public DetailDTO(Reply reply, Integer sessionUserId) {
            this.id = reply.getId();
            this.comment = reply.getComment();
            this.userId = reply.getUser().getId(); // lazy loading 안 됨
            this.username = reply.getUser().getUsername(); // lazy loading 안 됨 (user 영속화 되어있음)
            this.owner = reply.getUser().getId() == sessionUserId;
        }
    }
}
