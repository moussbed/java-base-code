# java-base-code

- #### **Creating Dates and Times**

  - **LocalDate** Contains just a date—no time and no time zone. A good example of LocalDate is your birthday this year. It is your birthday for a full day, regardless of what time it is.
  - **LocalTime** Contains just a time—no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day.
  - **LocalDateTime** Contains both a date and time but no time zone. A good example of LocalDateTime is “the stroke of midnight on New Year’s Eve.” Midnight on January 2 isn’t nearly as special, making the date relatively unimportant, and clearly an hour after midnight isn’t as special either.
  - **ZonedDateTime** Contains a date, time, and time zone. A good example of ZonedDateTime is “a conference call at 9:00 a.m. EST.” If you live in California, you’ll have to get up really early since the call is at 6:00 a.m. local time!
