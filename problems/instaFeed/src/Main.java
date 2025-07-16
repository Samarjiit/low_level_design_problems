import models.Post;
import models.User;
import services.FeedService;
import services.PostService;
import services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//User & Feed microservice of Instagram
//This code represents the User & Feed microservice of Instagram — managing users, posts, and the feed distribution mechanism. It interacts with media storage, auth, notification, and other microservices (not covered here) to build the full Instagram backend ecosystem.

public class Main {
    public static void main(String[] args) {
        UserService userService=UserService.getInstance();
        PostService postService=new PostService();
        FeedService feedService=new FeedService();

        User samar=userService.createUser("samar");
        User surya=userService.createUser("surya");
        User unmesh=userService.createUser("umnesh");

        samar.addFollower(surya);
        samar.addFollower(unmesh);


        Post post=postService.uploadPost(samar,new byte[]{1,2,3},"sunset vibes");
        feedService.distribute(post);


        System.out.println("surya's feed:" + feedService.getFeed(surya.getId(),10));
        System.out.println("unmesh's feed:" + feedService.getFeed(unmesh.getId(),10));



    }
}