## MySQL Database Design

### Table: appointments
- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key → doctors(id)
- patient_id: INT, Foreign Key → patients(id)
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)
- reason_for_visit: TEXT
- status: INT, NOT NULL (e.g., 0=Scheduled, 1=Completed, 2=Cancelled)
- created_at: DATETIME, NOT NULL

### Table: patients
- id: INT,Primary Key, Auto_Increment
- first_name: VARCHAR(50), NOT NULL
- last_name: VARCHAR(50), NOT NULL
- date_of_birth: DATE, NOT NULL 
- gender ENUM('Male', 'Female', 'other'), NOT NULL
- contact_email: VARCHAR(100), UNIQUE, NOT NULL
- Phone_number: VARCHAR(20)
- address: TEXT, NOT NULL
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Table: doctors
- id: INT,Primary Key, Auto_Increment
- first_name: VARCHAR(50), NOT NULL
- last_name: VARCHAR(50), NOT NULL
- specialty: VARCHAR(20), NOT NULL
- contact_email: VARCHAR(100), UNIQUE, NOT NULL
- Phone_number: VARCHAR(20)
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Table: admin
- id: INT AUTO_INCREMENT PRIMARY KEY,
- first_name VARCHAR(50) NOT NULL,
- last_name VARCHAR(50) NOT NULL,
- username VARCHAR(50) UNIQUE NOT NULL,
- password_hash VARCHAR(255) NOT NULL, -- Storing hashed passwords           is critical for security
- role ENUM('Admin', 'Receptionist', 'Manager') NOT NULL,
- created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

### Table: payments
//This table tracks patient payments and billing. 
- id: INT, Primary Key, AUTO_INCREMENT
- appointment_id: INT, Foreign Key → appointments(id), UNIQUE (each appointment can have one payment record)
- patient_id: INT, Foreign Key → patients(id), NOT NULL
- amount: DECIMAL(10, 2), NOT NULL
- payment_date: DATETIME, NOT NULL
- method: VARCHAR(50), NOT NULL (e.g., Credit Card, Cash, Insurance) 

### Table: clinic_locations
This table is useful for multi-location practices. 
- id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- address: VARCHAR(255), NOT NULL
- phone_number: VARCHAR(20)

### Table: doctor_availability
This table allows doctors to set their working hours, which can be referenced by the appointment scheduler. 
- id: INT, Primary Key, AUTO_INCREMENT
- doctor_id: INT, Foreign Key → doctors(id), NOT NULL
- day_of_week: INT, NOT NULL (e.g., 1=Monday, 2=Tuesday)
- start_time: TIME, NOT NULL
- end_time: TIME, NOT NULL 



## MongoDB Collection Design


### Collection: prescriptions
json
{
  "_id": "ObjectId('6533f81e0123456789abcdef')",
  "patientId": 7890,
  "doctorId": 12345,
  "appointmentId": 51,
  "prescribedAt": ISODate('2025-10-21T10:30:00.000Z'),
  "medications": [
    {
      "name": "Paracetamol",
      "dosage": "500mg",
      "instructions": "Take 1 tablet every 6 hours as needed for pain.",
      "refills": 2,
      "quantity": 60
    },
    {
      "name": "Amoxicillin",
      "dosage": "250mg",
      "instructions": "Take 1 capsule every 8 hours for 7 days.",
      "refills": 0,
      "quantity": 21
    }
  ],
  "doctorNotes": "Patient presented with a sinus infection. Prescribed antibiotics.",
  "pharmacyDetails": {
    "name": "Walgreens SF",
    "location": {
      "address": "123 Market Street",
      "city": "San Francisco",
      "state": "CA",
      "zip": "94103"
    }
  },
  "tags": [
    "antibiotic",
    "pain_relief"
  ]
}

### Collection: feedbacks
json
{
  "_id": "ObjectId('65340156abcdef0123456789')",
  "timestamp": ISODate('2025-10-20T11:00:00.000Z'),
  "patientId": 7890,
  "appointmentId": 51,
  "feedbackType": "post_appointment_survey",
  "rating": 4,
  "comments": "The doctor was very helpful, but the wait time was too long.",
  "surveyAnswers": {
    "waiting_room_experience": "comfortable",
    "doctor_communication": "excellent",
    "cleanliness": "good"
  },
  "tags": [
    "long_wait",
    "positive_doctor",
    "room_for_improvement"
  ],
  "metadata": {
    "submissionSource": "email_survey",
    "device": "desktop"
  }
}

### Collection: logs
json
{
  "_id": "ObjectId('653403a49876543210fedcba')",
  "timestamp": ISODate('2025-10-21T09:30:00.000Z'),
  "userId": 12345,
  "userRole": "doctor",
  "eventType": "update_patient_record",
  "details": {
    "patientId": 7890,
    "changes": [
      {
        "field": "last_name",
        "oldValue": "Smith",
        "newValue": "Johnson"
      },
      {
        "field": "email",
        "oldValue": "john.smith@example.com",
        "newValue": "john.johnson@example.com"
      }
    ]
  },
  "context": {
    "ipAddress": "192.168.1.10",
    "sessionId": "abc-123-xyz"
  },
  "tags": [
    "patient_data",
    "PII_change",
    "audit_trail"
  ]
}

### Collections: messages

json
{
  "_id": "ObjectId('653405c8fedcba9876543210')",
  "chatSessionId": "chat_session_xyz",
  "timestamp": ISODate('2025-10-21T10:00:00.000Z'),
  "senderId": 12345,
  "senderRole": "doctor",
  "recipientId": 7890,
  "recipientRole": "patient",
  "messageType": "text",
  "content": "Your lab results are ready for review.",
  "metadata": {
    "isRead": false,
    "sentVia": "mobile_app"
  },
  "attachments": [
    {
      "filename": "lab_results_oct_21.pdf",
      "fileUrl": "https://clinic.com/files/lab_results_oct_21.pdf"
    }
  ]
}

