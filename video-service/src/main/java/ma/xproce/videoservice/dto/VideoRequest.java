package ma.xproce.videoservice.dto;

public record VideoRequest(
        String name,
        String url,
        String description,
        String datePublication,

        CreatorRequest creator
) {}
