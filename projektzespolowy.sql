-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 03 Mar 2016, 19:21
-- Wersja serwera: 10.1.10-MariaDB
-- Wersja PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `projektzespolowy`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `premissions`
--

CREATE TABLE `premissions` (
  `id` int(11) NOT NULL,
  `nr` int(11) NOT NULL,
  `opis` text COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `premissions`
--

INSERT INTO `premissions` (`id`, `nr`, `opis`) VALUES
(1, 1, 'Użytkownik'),
(2, 777, 'admin, pełen dostęp');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `routes`
--

CREATE TABLE `routes` (
  `route_id` int(11) NOT NULL,
  `route_start` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `price` int(11) NOT NULL,
  `time_start` time NOT NULL,
  `duration` time NOT NULL,
  `distance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `routes`
--

INSERT INTO `routes` (`route_id`, `route_start`, `price`, `time_start`, `duration`, `distance`) VALUES
(1, 'asd', 0, '00:00:00', '00:00:00', 0),
(2, 'asd', 0, '00:00:00', '00:00:00', 0),
(3, 'a', 0, '00:00:00', '00:00:00', 0),
(4, 'a', 0, '00:00:00', '00:00:00', 0),
(5, 'a', 0, '00:00:00', '00:00:00', 0),
(6, 'a', 0, '00:00:00', '00:00:00', 0),
(7, 'a', 0, '00:00:00', '00:00:00', 0),
(8, 'dom', 0, '00:00:00', '00:00:00', 0),
(9, 'ddd', 0, '00:00:00', '00:00:00', 0),
(10, 'aa', 0, '00:00:00', '00:00:00', 0),
(11, 'qwe', 0, '00:00:00', '00:00:00', 0),
(12, 'fff', 0, '00:00:00', '00:00:00', 0),
(13, 'darek', 0, '00:00:00', '00:00:00', 0),
(14, 'fds', 0, '00:00:00', '00:00:00', 0),
(15, 'dom', 100, '00:00:00', '02:03:00', 32),
(16, 'asd', 32, '17:56:00', '00:02:00', 3),
(17, 'asd', 23, '19:51:00', '00:02:00', 3),
(18, 'Ko?obrzeg', 30, '18:09:00', '00:38:00', 64),
(19, 'd', 2, '18:09:00', '00:14:00', 5),
(20, 'asd', 32, '18:10:00', '00:03:00', 4),
(21, 'Ko?obrzeg', 12, '18:10:00', '01:17:00', 51),
(22, 'Ko?obrzeg', 123, '18:12:00', '01:04:00', 46),
(23, 'Ko?o', 12, '18:13:00', '00:35:00', 34),
(24, 'a', 2, '18:13:00', '00:02:00', 3),
(25, 'a', 2, '18:16:00', '00:02:00', 3),
(26, 'asd', 32, '18:16:00', '00:02:00', 3),
(27, 'Ko?obrzeg', 123, '18:17:00', '00:44:00', 55),
(28, 'domek', 111, '18:18:00', '05:33:00', 333),
(29, 'a', 1, '18:20:00', '00:02:00', 2),
(30, 'asd', 23, '18:23:00', '00:02:00', 2);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `routes_stops`
--

CREATE TABLE `routes_stops` (
  `id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `distance` int(11) NOT NULL,
  `stop_time` time NOT NULL,
  `nr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `routes_stops`
--

INSERT INTO `routes_stops` (`id`, `route_id`, `name`, `distance`, `stop_time`, `nr`) VALUES
(1, 12, 'a1', 0, '00:00:00', 1),
(2, 12, 'a2', 0, '00:00:00', 2),
(3, 13, 'qweqwe', 0, '00:00:00', 1),
(4, 13, 'ewqeqwe', 0, '00:00:00', 2),
(5, 13, 'asdad', 0, '00:00:00', 3),
(6, 14, 'asdads', 0, '00:00:00', 1),
(7, 14, 'asdasd', 0, '00:00:00', 2),
(8, 26, 'a', 3, '00:00:00', 1),
(9, 27, 'Bia?ogard', 32, '00:00:00', 1),
(10, 27, 'Szczecinek', 23, '00:00:00', 2),
(11, 28, 'domek1', 111, '01:51:00', 1),
(12, 28, 'domek2', 222, '03:42:00', 2),
(13, 29, '???????ó', 2, '00:02:00', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(25) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_polish_ci NOT NULL,
  `access` int(11) NOT NULL,
  `banned` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `access`, `banned`) VALUES
(28, 'admin', '21232f297a57a5a743894a0e4a801fc3', 777, 0),
(29, 'darek', 'b64a76fbfcbc7b85bc416a53240bb077', 1, 1),
(30, 'lol', '9cdfb439c7876e703e307864c9167a15', 1, 0),
(31, 'adminek', 'd9a96f43912fdf91c308f4565ea84ec9', 1, 0);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `premissions`
--
ALTER TABLE `premissions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `routes`
--
ALTER TABLE `routes`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `routes_stops`
--
ALTER TABLE `routes_stops`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `premissions`
--
ALTER TABLE `premissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `routes`
--
ALTER TABLE `routes`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT dla tabeli `routes_stops`
--
ALTER TABLE `routes_stops`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
