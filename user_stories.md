# User Stories

## Admin User Stories

**Title:** _As an admin, I want to securely log into the portal, so that I can manage the platform._
**Acceptance Criteria:**
1. The system displays a login page with username and password fields.
2. Upon successful authentication, the admin is redirected to the admin dashboard.
3. Invalid credentials display an error message.
**Priority:** High
**Story Points:** 3
**Notes:** - Implement robust password hashing and secure session management.

**Title:** _As an admin, I want to log out of the portal, so that I can protect system access._
**Acceptance Criteria:**
1. A logout button is clearly visible on the admin dashboard.
2. Clicking the logout button terminates the admin's session.
3. After logging out, the admin is redirected to the login page.
**Priority:** High
**Story Points:** 1
**Notes:** - Ensure all session data is cleared upon logout.

**Title:** _As an admin, I want to add doctors to the portal, so that they can manage their schedules and appointments._
**Acceptance Criteria:**
1. The admin can access a form to input doctor details (name, specialization, contact info).
2. Upon submission, a new doctor profile is created in the system.
3. The system validates input fields to ensure data integrity.
**Priority:** Medium
**Story Points:** 5
**Notes:** - Consider email verification for newly added doctors.

**Title:** _As an admin, I want to delete a doctor's profile from the portal, so that I can manage active users._
**Acceptance Criteria:**
1. The admin can view a list of registered doctors.
2. The admin can select a doctor and initiate the deletion process.
3. A confirmation prompt appears before permanent deletion.
**Priority:** Medium
**Story Points:** 3
**Notes:** - Address potential data integrity issues related to past appointments.

**Title:** _As an admin, I want to run a stored procedure in MySQL CLI to get the number of appointments per month, so that I can track usage statistics._
**Acceptance Criteria:**
1. The admin can execute a pre-defined stored procedure in the MySQL CLI.
2. The stored procedure returns accurate monthly appointment counts.
3. The output is clearly formatted and easy to interpret.
**Priority:** Low
**Story Points:** 8
**Notes:** - Ensure the stored procedure is optimized for performance.

## Patient User Stories

**Title:** _As a patient, I want to view a list of doctors without logging in, so that I can explore options before registering._
**Acceptance Criteria:**
1. The public homepage displays a list of available doctors with basic information (name, specialization).
2. The list is accessible without requiring user authentication.
3. Users can filter or search the list by specialization.
**Priority:** High
**Story Points:** 3
**Notes:** - Only display publicly available information for doctors.

**Title:** _As a patient, I want to sign up using my email and password, so that I can book appointments._
**Acceptance Criteria:**
1. The system provides a registration form for new patients.
2. The system sends a confirmation email to verify the user's account.
3. Upon successful registration and verification, the patient can log in.
**Priority:** High
**Story Points:** 5
**Notes:** - Implement strong password requirements.

**Title:** _As a patient, I want to log into the portal, so that I can manage my bookings._
**Acceptance Criteria:**
1. The system displays a login page with email and password fields.
2. Upon successful authentication, the patient is redirected to their dashboard.
3. Invalid credentials display an error message.
**Priority:** High
**Story Points:** 3
**Notes:** - Provide a "forgot password" option.

**Title:** _As a patient, I want to log out of the portal, so that I can secure my account._
**Acceptance Criteria:**
1. A logout button is clearly visible on the patient dashboard.
2. Clicking the logout button terminates the patient's session.
3. After logging out, the patient is redirected to the login page.
**Priority:** High
**Story Points:** 1
**Notes:** - Ensure all session data is cleared upon logout.

**Title:** _As a patient, I want to book an hour-long appointment to consult with a doctor, so that I can receive medical advice._
**Acceptance Criteria:**
1. The patient can select a doctor and view their available time slots.
2. The patient can choose a one-hour time slot for an appointment.
3. A confirmation message is displayed upon successful booking.
**Priority:** High
**Story Points:** 8
**Notes:** - Integrate with doctor's availability and prevent double-booking.

**Title:** _As a patient, I want to view my upcoming appointments, so that I can prepare accordingly._
**Acceptance Criteria:**
1. The patient dashboard displays a list of all upcoming appointments.
2. Each appointment entry includes details like doctor's name, date, and time.
3. The list is sorted chronologically.
**Priority:** Medium
**Story Points:** 3
**Notes:** - Consider adding an option to cancel or reschedule appointments.

## Doctor User Stories

**Title:** _As a doctor, I want to log into the portal, so that I can manage my appointments._
**Acceptance Criteria:**
1. The system displays a login page with username and password fields.
2. Upon successful authentication, the doctor is redirected to their dashboard.
3. Invalid credentials display an error message.
**Priority:** High
**Story Points:** 3
**Notes:** - Implement secure login procedures.

**Title:** _As a doctor, I want to log out of the portal, so that I can protect my data._
**Acceptance Criteria:**
1. A logout button is clearly visible on the doctor dashboard.
2. Clicking the logout button terminates the doctor's session.
3. After logging out, the doctor is redirected to the login page.
**Priority:** High
**Story Points:** 1
**Notes:** - Ensure all sensitive data is inaccessible after logout.

**Title:** _As a doctor, I want to view my appointment calendar, so that I can stay organized._
**Acceptance Criteria:**
1. The doctor dashboard displays a calendar view of all scheduled appointments.
2. Appointments are clearly marked with patient names and times.
3. The calendar allows navigation between different dates/weeks/months.
**Priority:** High
**Story Points:** 5
**Notes:** - Provide options for daily, weekly, and monthly views.

**Title:** _As a doctor, I want to mark my unavailability, so that I can inform patients only of available slots._
**Acceptance Criteria:**
1. The doctor can select specific time blocks or days as unavailable on their calendar.
2. Marked unavailability prevents patients from booking appointments during those times.
3. The system visually indicates unavailable slots on the doctor's calendar.
**Priority:** Medium
**Story Points:** 5
**Notes:** - Allow for recurring unavailability (e.g., every Tuesday afternoon).

**Title:** _As a doctor, I want to update my profile information, so that patients have accurate details._
**Acceptance Criteria:**
1. The doctor can access and edit their profile details (specialization, contact info, bio).
2. Changes are saved and reflected in the public-facing doctor list.
3. The system validates input fields before saving.
**Priority:** Medium
**Story Points:** 3
**Notes:** - Implement a review process for significant profile changes.