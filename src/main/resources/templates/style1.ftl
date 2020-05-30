% !TEX TS-program = xelatex
% !TEX encoding = UTF-8 Unicode
% !Mode:: "TeX:UTF-8"

\documentclass{resume}
\usepackage{zh_CN-Adobefonts_external} % Simplified Chinese Support using external fonts (./fonts/zh_CN-Adobe/)
% \usepackage{NotoSansSC_external}
% \usepackage{NotoSerifCJKsc_external}
% \usepackage{zh_CN-Adobefonts_internal} % Simplified Chinese Support using system fonts
\usepackage{linespacing_fix} % disable extra space before next section
\usepackage{cite}

\begin{document}
\pagenumbering{gobble} % suppress displaying page number

\name{${name}}

\leftline{\Large\centerline{\textbf{求职意向: ${job}}}}
\vspace{0.5ex}

\basicInfo{
  \email{${mail}} \textperiodcentered\
  \phone{(+86) ${phone}}
}

\section{\faInfo\  个人信息 }
\vspace{0.5ex}
\leftline {
	性别:{${sex}}  \hfill 出生年月:{${date}}\hfill 民族:{${nation}}
}
\vspace{0.5ex}
\leftline{
	籍贯:{${home}}\hfill 政治面貌:{${face}}  \hfill 婚姻状况:{${marry}}
}
\vspace{0.5ex}

\section{\faJob\  求职意向}
\leftline{
	意向工作城市:{${city}}\hfill 期望薪资:{${money}}
}
\vspace{0.5ex}

\section{\faGraduationCap\  教育背景}
\leftline{
	{\textbf{${school}}}\hfill{${degree}} \hfill {${major}}\hfill{${study_start_day} 至 ${study_stop_day}}
}
\vspace{0.5ex}
\qquad ${school_descrip}
\vspace{0.5ex}

\section{\faSchool\  学校情况}
\vspace{0.5ex}
\leftline{\textbf{校园经历}}
\qquad ${school_experience}
\vspace{0.5ex}


\section{\faUsers\ 实习/项目经历}
\vspace{0.5ex}
\qquad ${job_experience}
\vspace{0.5ex}


%\datedsubsection{\textbf{\LaTeX\ 简历模板}}{2015 年5月 -- 至今}
%\role{\LaTeX, Python}{个人项目}
%\begin{onehalfspacing}
%优雅的 \LaTeX\ 简历模板, https://github.com/billryan/resume
%\begin{itemize}
%  \item 容易定制和扩展
%  \item 完善的 Unicode 字体支持，使用 \XeLaTeX\ 编译
%  \item 支持 FontAwesome 4.5.0
%\end{itemize}
%\end{onehalfspacing}

\section{\faCogs\  IT 技能}
\vspace{0.5ex}
\qquad ${skill}
\vspace{0.5ex}


%\begin{itemize}[parsep=0.5ex]
%  \item 编程语言: C == Python > C++ > Java
%  \item 平台: Linux
%  \item 开发: xxx
%\end{itemize}

\section{\faAward\ 获奖情况}
\vspace{0.5ex}
\qquad ${award}
\vspace{0.5ex}

\section{\faOther\ 个人情况}
\vspace{0.5ex}
\par{\textit{兴趣爱好}}\par \*
\qquad ${interest}
\vspace{0.5ex}
\par{\textit{自我评价}}\par \*
\qquad ${evaluate}

\end{document}