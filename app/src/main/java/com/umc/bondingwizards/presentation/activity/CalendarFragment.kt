package com.umc.bondingwizards.presentation.activity

import android.icu.text.SimpleDateFormat
import android.view.View
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.prolificinteractive.materialcalendarview.format.DateFormatTitleFormatter
import com.prolificinteractive.materialcalendarview.format.TitleFormatter
import dagger.hilt.android.AndroidEntryPoint
import com.umc.bondingwizards.databinding.FragmentCalendarBinding
import com.umc.bondingwizards.presentation.adapter.PlanRVAdapter
import com.umc.bondingwizards.utils.binding.BindingFragment
import java.util.Calendar
import java.util.Locale


@AndroidEntryPoint
class CalendarFragment: BindingFragment<FragmentCalendarBinding>(com.umc.bondingwizards.R.layout.fragment_calendar) {
    lateinit var planRVAdapter: PlanRVAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var items : ArrayList<String> = ArrayList()
        items.add("테디 생일")
        items.add("커너 졸업식")

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
        binding.calendarView.setOnDateChangedListener { widget, date, selected ->
            if (selected) {
                // 선택한 날짜를 이용하여 원하는 작업 수행
                showBottomDialog(items)
                Log.d("CalendarFragment", "Selected Date: $date")
            }
        }


//        //게시물 RecyclerView에 adapter 연결
//        planRVAdapter = PlanRVAdapter(requireContext(), this@CalendarFragment)
//        planRVAdapter.setMyItemClickListener(object: PlanRVAdapter.MyItemClickListener{
//            override fun onClickComment(planList: ArrayList<String>) {
//                showBottomDialog(planList)
//            }
//        })
//        binding.bottom.adapter = planRVAdapter
//        binding.homePostRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        DateFormatTitleFormatter()

    }

//    inner class MyTitleFormatter : TitleFormatter {
//        override fun format(day: CalendarDay?): CharSequence {
//            val simpleDateFormat =
//                SimpleDateFormat("yyyy.MM", Locale.US) //"February 2016" format
//
//            return simpleDateFormat.format(Calendar.getInstance().getTime())
//        }
//
//    }

    inner class MyTitleFormatter : TitleFormatter {
        override fun format(day: CalendarDay?): CharSequence {
            day?.let {
                val simpleDateFormat = SimpleDateFormat("yyyy.MM", Locale.US)
                val calendar = Calendar.getInstance()
                calendar.set(it.year, it.month-1, it.day)
                return simpleDateFormat.format(calendar.time)
            } ?: run {
                return "" // day가 null인 경우 처리 (원하는 방식으로 처리)
            }
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
    private fun showBottomDialog(planList: ArrayList<String>) {
        val bottomsheet = PlanBottomSheet(planList)
        bottomsheet.show(requireActivity().supportFragmentManager, "CommentBottomSheet")
    }
}