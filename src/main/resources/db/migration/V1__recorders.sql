CREATE TABLE `recorder` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `name` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
    `date_of_birth` date,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;
