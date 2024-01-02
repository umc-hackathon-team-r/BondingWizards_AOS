package com.umc.bondingwizards.presentation.activity

import android.view.View
import androidx.navigation.fragment.findNavController
import android.os.Bundle
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.format.DateFormatTitleFormatter
import com.prolificinteractive.materialcalendarview.format.TitleFormatter
import dagger.hilt.android.AndroidEntryPoint
import com.umc.bondingwizards.databinding.FragmentCalendarBinding
import com.umc.bondingwizards.utils.binding.BindingFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


@AndroidEntryPoint
class CalendarFragment: BindingFragment<FragmentCalendarBinding>(com.umc.bondingwizards.R.layout.fragment_calendar) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val today = CalendarDay.today()

        val disabledDates = hashSetOf<CalendarDay>()
        disabledDates.add(CalendarDay.from(2022, 7, 12))

        binding.calendarView.apply {
            // 휴무일 지정을 위한 Decorator 설정
            addDecorator(DayDisableDecorator(disabledDates, today))
            // 요일을 지정하귀 위해 {"월", "화", ..., "일"} 배열을 추가한다.
            setWeekDayLabels(arrayOf("월", "화", "수", "목", "금", "토", "일"))
            // 달력 상단에 `월 년` 포맷을 수정하기 위해 TitleFormatter 설정
            setTitleFormatter(MyTitleFormatter())
        }

        DateFormatTitleFormatter()

    }

    inner class MyTitleFormatter : TitleFormatter {
        override fun format(day: CalendarDay?): CharSequence {
            val simpleDateFormat =
                SimpleDateFormat("yyyy.MM", Locale.US) //"February 2016" format

            return simpleDateFormat.format(Calendar.getInstance().getTime())
        }

    }

    inner class DayDisableDecorator : DayViewDecorator {
        private var dates = HashSet<CalendarDay>()
        private var today: CalendarDay

        constructor(dates: HashSet<CalendarDay>, today: CalendarDay) {
            this.dates = dates
            this.today = today
        }

        override fun shouldDecorate(day: CalendarDay): Boolean {
            // 휴무일 || 이전 날짜
            return dates.contains(day) || day.isBefore(today)
        }

        override fun decorate(view: DayViewFacade?) {
            view?.let { it.setDaysDisabled(true) }
        }
    }
}