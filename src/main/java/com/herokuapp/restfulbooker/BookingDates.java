package com.herokuapp.restfulbooker;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BookingDates {

    private String checkin;
    private String checkout;

}
