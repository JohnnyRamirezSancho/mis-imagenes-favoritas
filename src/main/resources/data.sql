INSERT INTO users (id_user, username, password) VALUES (default, 'admin@esto.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, username, password) VALUES (default, 'user@esto.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')

INSERT INTO roles (id_role, role) VALUES (default, 'ROLE_ADMIN')
INSERT INTO roles (id_role, role) VALUES (default, 'ROLE_USER')

INSERT INTO roles_users (user_id, role_id) VALUES (1, 1)
INSERT INTO roles_users (user_id, role_id) VALUES (2, 2)

INSERT INTO imagegallery (id_imagegallery, image) VALUES (default, 'cripta-sagrada-familia-01.jpg')
INSERT INTO imagegallery (id_imagegallery, image) VALUES (default, 'cripta-sagrada-familia-02.jpg')
INSERT INTO imagegallery (id_imagegallery, image) VALUES (default, 'cripta-sagrada-familia-03.jpg')
INSERT INTO imagegallery (id_imagegallery, image) VALUES (default, 'sagrada-familia-01.jpg')
INSERT INTO imagegallery (id_imagegallery, image) VALUES (default, 'sagrada-familia-02.jpg')
INSERT INTO imagegallery (id_imagegallery, image) VALUES (default, 'sagrada-familia-03.jpg')

INSERT INTO itemgallery (id_itemgallery, title, imagegallery_id_imagegallery) VALUES (default, 'Cripta de la Sagrada Familia 01', 1)
INSERT INTO itemgallery (id_itemgallery, title, imagegallery_id_imagegallery) VALUES (default, 'Cripta de la Sagrada Familia 02', 2)
INSERT INTO itemgallery (id_itemgallery, title, imagegallery_id_imagegallery) VALUES (default, 'Cripta de la Sagrada Familia 03', 3)
INSERT INTO itemgallery (id_itemgallery, title, imagegallery_id_imagegallery) VALUES (default, 'Sagrada Familia 01', 4)
INSERT INTO itemgallery (id_itemgallery, title, imagegallery_id_imagegallery) VALUES (default, 'Sagrada Familia 02', 5)
INSERT INTO itemgallery (id_itemgallery, title, imagegallery_id_imagegallery) VALUES (default, 'Sagrada Familia 03', 6)
