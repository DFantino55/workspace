package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

@Path("/bookings")
@Tag(name = "Bookings", description = "Handling of Bookings")
@RolesAllowed({ "User", "Admin" })
public class BookingController {

    @Inject
    BookingService bookingService;

    @Path("/{id}")
    @GET
    @Operation(
        summary = "Gets Booking by ID",
        description = "Gets a specific Booking by its ID"
    )
    public Booking get(@PathParam("id") Long id) {
        return bookingService.findByID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all bookings.", 
        description = "Returns a list of all bookings."
    )
    public List<Booking> index() {
        return bookingService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Creates a new Booking.", 
        description = "Creates a new booking and returns the newly added booking."
    )
    public Booking create(Booking booking) {
       return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "Deletes a booking.",
        description = "Deletes an booking by its id."
    )
    public void delete(@PathParam("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @Path("/{id}")
    @PUT
    @Operation(
        summary = "Updates a booking.",
        description = "Updates a booking by its id."
    )
    public Booking update(@PathParam("id") Long id, Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @Path("accept/{id}")
    @PUT
    @Operation(
        summary = "Accept a booking.",
        description = "Accepts a booking by its id."
    )
    public Booking acceptBooking(@PathParam("id") Long id) {
        return bookingService.acceptBooking(id);
    } 

    @Path("reject/{id}")
    @PUT
    @Operation(
        summary = "Reject a booking.",
        description = "Rejects a booking by its id."
    )
    public Booking rejectBooking(@PathParam("id") Long id) {
        return bookingService.rejectBooking(id);
    } 

}
