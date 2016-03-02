-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 02 Mar 2016, 22:27
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
(15, 'dom', 100, '00:00:00', '02:03:00', 32);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `routes_stops`
--

CREATE TABLE `routes_stops` (
  `id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `distance` int(11) NOT NULL,
  `nr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `routes_stops`
--

INSERT INTO `routes_stops` (`id`, `route_id`, `name`, `distance`, `nr`) VALUES
(1, 12, 'a1', 0, 1),
(2, 12, 'a2', 0, 2),
(3, 13, 'qweqwe', 0, 1),
(4, 13, 'ewqeqwe', 0, 2),
(5, 13, 'asdad', 0, 3),
(6, 14, 'asdads', 0, 1),
(7, 14, 'asdasd', 0, 2);

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
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT dla tabeli `routes_stops`
--
ALTER TABLE `routes_stops`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
