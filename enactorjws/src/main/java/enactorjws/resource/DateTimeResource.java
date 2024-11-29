package enactorjws.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Path("/datetime")
public class DateTimeResource {

    // String response
    @GET
    @Path("/string")
    @Operation(
        summary = "Get current date and time as a string",
        description = "Returns the current date and time in the format yyyy-MM-dd HH:mm:ss."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Successful response",
            content = @Content(schema = @Schema(type = "string"))
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
        )
    })
    public String getCurrentDateTimeAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // JSON response
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON) // Specify JSON response
    @Operation(
        summary = "Get current date and time as JSON",
        description = "Returns the current date and time in JSON format."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Successful response",
            content = @Content(
                mediaType = MediaType.APPLICATION_JSON,
                schema = @Schema(implementation = DateTime.class)
            )
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error"
        )
    })
    public DateTime getCurrentDateTimeAsJson() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sdf.format(new Date());
        return new DateTime(currentDate); // Return a DateTime object as JSON
    }

    // Inner class to represent DateTime in JSON format
    public static class DateTime {
        @Schema(description = "The current date and time in the format yyyy-MM-dd HH:mm:ss")
        private String currentDate;

        public DateTime(String currentDate) {
            this.currentDate = currentDate;
        }

        public String getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }
    }
}