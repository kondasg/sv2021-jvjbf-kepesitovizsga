CREATE TABLE `world_record` (
    `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `description` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
    `value` double NOT NULL,
    `unit_of_measure` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
    `date_of_record` date,
    `recorder_id` bigint(20) UNSIGNED NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;
