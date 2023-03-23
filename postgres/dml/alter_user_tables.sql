INSERT INTO fitness.user_role(id, role)
VALUES (1, 'ADMIN'),
       (2, 'USER');
INSERT INTO fitness.user_status(id, status)
VALUES (1, 'WAITING_ACTIVATION'),
       (2, 'ACTIVATED'),
       (3, 'DEACTIVATED');
INSERT INTO fitness.user(id, dt_create, dt_update,
                         mail, fio, password, status, role)
VALUES ('3bd6f642-c31b-11ed-afa1-0242ac120002', NOW(), NOW(),
        'kulinenko34@gmail.com', 'Admin', 11, 2, 1);