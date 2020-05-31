\documentclass[11pt,a4paper]{moderncv}
\usepackage{fontspec,xunicode}
\setmainfont{Tahoma}
\usepackage[slantfont,boldfont]{xeCJK}
\usepackage{xcolor}                 % replace by the encoding you are using
\setCJKmainfont{Adobe Song Std L}
\moderncvtheme[blue]{classic}             

% adjust the page margins
\usepackage[scale=0.8]{geometry}
%\setlength{\hintscolumnwidth}{3cm}						% if you want to change the width of the column with the dates
%\AtBeginDocument{\setlength{\maketitlenamewidth}{6cm}}  % only for the classic theme, if you want to change the width of your name placeholder (to leave more space for your address details
\AtBeginDocument{\recomputelengths}                     % required when changes are made to page layout lengths

% personal data
\firstname{${name}} 
\familyname{}
\title{意向：\textbf{${job}}}               % optional, remove the line if not wanted
%\address{杭州}{中国}    % optional, remove the line if not wanted
%\mobile{}                    % optional, remove the line if not wanted
%\phone{}                      % optional, remove the line if not wanted
%\fax{}                          % optional, remove the line if not wanted
%\email{}                     % optional, remove the line if not wanted
%\extrainfo{} % optional, remove the line if not wanted
\quote{ 手机号：${phone} \qquad 邮箱：${mail}}                 % optional, remove the line if not wante

%\nopagenumbers{}                             % uncomment to suppress automatic page numbering for CVs longer than one page


%----------------------------------------------------------------------------------
%            content
%----------------------------------------------------------------------------------
\begin{document}
\maketitle

\section{基本信息}
\vspace{0.5ex}
\leftline {
	性别:{${sex}}  \hfill 出生年月:{${date}}\hfill 民族:{${nation}}
}
\vspace{0.5ex}
\leftline{
	籍贯:{${home}}\hfill 政治面貌:{${face}}  \hfill 婚姻状况:{${marry}}
}
\vspace{0.5ex}

\section{求职意向}
\cvcomputer{意向城市：}{${city}}{期望薪资：}{${money}}

\section{教育背景}
\cventry{${study_start_day} 至 ${study_stop_day}}{${school}}{${degree}}{${major}}{}{${school_descrip}}          
%\subsection{Miscellaneous}
%\cventry{year--year}{Job title}{Employer}{City}{}{Description line 1\newline{}Description line 2}% arguments 3 to 6 are optional

\section{校园经历}
\qquad ${school_experience}

\section{项目/实习经历}
\qquad ${job_experience}

\section{技能特长}
\qquad ${skill}

\section{获奖情况}
\qquad ${award}

\section{个人情况}
\subsection{兴趣爱好}
\qquad ${interest}
\subsection{自我评价}
\qquad ${evaluate}


%\section{论坛历史}
%\subsection{Vocational}
%\cvline{title}{\emph{Title}}
%\cvline{supervisors}{Supervisors}
%\cvline{description}{\small Short thesis abstract}


%\section{Languages}
%\cvlanguage{language 1}{Skill level}{Comment}
%\cvlanguage{language 2}{Skill level}{Comment}
%\cvlanguage{language 3}{Skill level}{Comment}

%\section{Computer skills}
%\cvcomputer{category 1}{XXX, YYY, ZZZ}{category 4}{XXX, YYY, ZZZ}
%\cvcomputer{category 2}{XXX, YYY, ZZZ}{category 5}{XXX, YYY, ZZZ}
%\cvcomputer{category 3}{XXX, YYY, ZZZ}{category 6}{XXX, YYY, ZZZ}

%\section{Interests}
%\cvline{篮球}{\small 体力与技巧}
%\cvline{hobby 2}{\small Description}
%\cvline{hobby 3}{\small Description}
%\renewcommand{\listitemsymbol}{-} % change the symbol for lists

%\section{Extra 1}
%\cvlistitem{Item 1}
%\cvlistitem{Item 2}

%\section{Extra 2}
%\cvlistdoubleitem{测试1}{测试2}

%% Publications from a BibTeX file
%\nocite{*}
%\bibliographystyle{plain}
%\bibliography{publications}       % 'publications' is the name of a BibTeX file

%\begin{thebibliography}{99}
%\bibitem{11} LaTeX入门与提高，高等教育出版社。
%\end{thebibliography}
%LaTeX入门与提高，高等教育出版社。

\end{document}