package services;

import models.Post;
import models.User;

public class PostService {
        private final MediaService mediaService=new MediaService();

        public Post uploadPost(User user, byte[] media, String caption){
            String mediaUrl=mediaService.uploadMedia(media);
            Post post=new Post(user.getId(),mediaUrl,caption);
            System.out.println("post uploaded"+post.getId());

            return post;
        }

}
