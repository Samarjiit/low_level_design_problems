package services;

import java.util.UUID;

public class MediaService {
    public String uploadMedia(byte[] mediaBytes){
        return "https://cdn.s3/"+ UUID.nameUUIDFromBytes(mediaBytes);
    }
}
